
module.exports = (sequelize,DataTypes) => {
    const Student = sequelize.define('student', {
        // Model attributes are defined here
        id: {
          type: DataTypes.INTEGER,
          autoIncrement: true,
          primaryKey: true
        },
        name: {
          type: DataTypes.STRING
          // allowNull defaults to true
        },
        rollNo: {
            type: DataTypes.INTEGER
            // allowNull defaults to true
        },
        dateOfBirth: {
            type: DataTypes.STRING
            // allowNull defaults to true
        },
        score: {
            type: DataTypes.INTEGER
            // allowNull defaults to true
        }
      }, {
        // Other model options go here
        timestamps: false
      });
      module.exports = Student
      return Student
}