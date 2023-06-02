/**
 * Database connectionwith the local storage using Sequelize
 */
const { Sequelize, DataTypes } = require('sequelize');
const sequelize = new Sequelize('result_management_system', 'root', 'root', {
    host: 'localhost',
    dialect:  'mysql'
  });

  try {
    sequelize.authenticate();
    console.log('Connection has been established successfully.');
  } catch (error) {
    console.error('Unable to connect to the database:', error);
  }

  const db = {}
  db.Sequelize = Sequelize
  db.sequelize = sequelize

  db.teachers = require('../models/teacher.js')(sequelize,DataTypes)
  db.students = require('../models/student.js')(sequelize, DataTypes)
  db.sequelize.sync({force:false})
  .then(() => {
    console.log('re-sync done')
})

  module.exports = db
