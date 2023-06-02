/**
 * Student controller with all api related to student
 */
const express = require('express')
const app = express()
const Teacher = require('../models/teacher.js')
const auth = require('../middleware/auth.js')
const router = express.Router()
const Student = require('../models/student.js')

/**
 * Function to delete a student from the database with its Student ID
 */
router.get('/deleteStudent/:id',async(req,res) =>{
    console.log(req.params.id)
    const student = await Student.destroy({
      where: {
        id: req.params.id
      }
    });
    const students = await Student.findAll({})
    res.render('teacher_dashboard',{students,user:req.cookies.user})
  })

/**
 * Function to show the result of a student if roll number and date of birth are correct
 */
router.post('/student/result',async(req, res) => {
    let status = 'null'
    const student = await Student.findOne({ where: {
      rollNo: req.body.rollNo
    }})
    if(student!=null){
      if(student.dateOfBirth==req.body.dateOfBirth){
        res.render('show_result',{student:student})
      }else{
        status = 'failed'
        res.render('student_login',{status:status})
      }
    }
    else{
      status = 'failed'
      res.render('student_login',{status,status})
    }
  })
module.exports = router