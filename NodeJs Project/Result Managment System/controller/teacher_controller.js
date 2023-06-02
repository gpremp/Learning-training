/**
 * Teacher controller with all API related to teacher's operations
 */
const express = require('express')
const Teacher = require('../models/teacher.js')
const auth = require('../middleware/auth.js')
const router = express.Router()
const Student = require('../models/student.js')
/**
 * Api to create a new teacher account
 */
router.post('/teacher/signup',async(req, res) => {
  let status = 'null'
  console.log(req.body.email);
  const teacher = await Teacher.findOne({ where: {
    email: req.body.email
  }})
  if(teacher==null){
    const newteacher = new Teacher({
      firstName : req.body.firstName,
      lastName:req.body.lastName,
      email:req.body.email,
      password:req.body.password
    })
    newteacher.save();
    status = 'success'
  }else{
    status = 'failed'
  }
  res.render('teacher_signup',{status:status})
})

/**
 * Api to authenticate a teacher With e-mail ID and password and redirect to teacher dashboard
 */
router.post('/teacher/login',async(req, res) => {
  let status = 'null'
  console.log(req.body);
  const teacher = await Teacher.findOne({ where: {
    email: req.body.email
  }})
  if(teacher!=null){
    if(teacher.password==req.body.password){
      const students = await Student.findAll({})
      res.cookie('user',teacher.firstName)
      res.render('teacher_dashboard',{user:teacher.firstName,students})
    }else{
      status = 'failed'
      res.render('teacher_login',{status:status})
    }
    
  }else{
    status = 'failed'
    res.render('teacher_login',{status:status})
  }
 
})
/**
 * API to redirect teacher dashboard with all its studentd Details
 */
router.get('/teacher/dashboard',auth,async (req,res) =>{
  const students = await Student.findAll({})
  res.render('teacher_dashboard',{students,user:req.cookies.user})
})
/**
 * API to redirect student Registration page to add new student details into database
 */
router.get('/teacher/student',auth, (req, res) => {
  res.render('addStudent',{status:'null',user:req.cookies.user})
})

router.post('/student/registration',async(req, res) => {
  let status = 'null'
  const student = await Student.findOne({ where: {
    rollNo: req.body.rollNo
  }})
  if(student==null){
    const newStudent = new Student(req.body)
    status = 'success'
    newStudent.save();
  }else{
    status = 'failed'
  }
  res.render('addStudent',{status:status,user:req.cookies.user})
 
})
/**
 * API to update student details
 */
router.post('/teacher/student/update',async(req,res) =>{
  const student = await Student.update({ name:req.body.name,dateOfBirth:req.body.dateOfBirth,score:req.body.score }, {
    where: {
      id: req.body.id
    }
  });
  res.render('updateStudent',{student:req.body,user:req.cookies.user,status:'success'})
})

module.exports = router