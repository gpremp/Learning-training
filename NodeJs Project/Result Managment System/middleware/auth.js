/**
 * Function to authenticate user while accessing secure pages
 */
const auth = async (req,res,next) =>{
    const user = req.cookies.user
    console.log(user)
    if(user==undefined || user == null){
        res.send('Session logout! Please LogIn again')
    }else{
        next()
    }
   
}
module.exports = auth