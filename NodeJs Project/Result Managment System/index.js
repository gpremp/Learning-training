const express = require('express')
const app = express()
require('./database/connections.js')
const Student = require('./models/student.js')
const auth = require('./middleware/auth.js')
const techerRouter = require('./controller/teacher_controller.js')
var cookieParser = require('cookie-parser');
app.use(cookieParser());
const port = 3000
app.use('/assets',express.static('assets'))
app.set('view engine','ejs')
app.use(express.json())
app.use(express.urlencoded({extended : false}))
const studentRouter = require('./controller/student_controller.js')
app.use('/',studentRouter)
app.use('/',techerRouter)
app.get('/', (req, res) => {
  res.render('homepage')
})
app.get('/teacher/login', (req, res) => {
  res.render('teacher_login',{status:'null'})
})
app.get('/teacher/signup', (req, res) => {
    res.render('teacher_signup',{status:''})
})

app.get('/student/login', (req, res) => {
  res.render('student_login',{status:'null'})
})

app.get('/teacher/updateStudent/:id',auth, async (req, res) => {
  const student = await Student.findOne({where: {
    id: req.params.id
  }})
  res.render('updateStudent',{student:student,user:req.cookies.user,status:''})
})
app.get('/logout',async (req,res) =>{
  res.clearCookie('user');
  res.render('homepage')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})