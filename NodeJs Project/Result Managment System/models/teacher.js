
module.exports = (sequelize,DataTypes) => {
    const Teacher = sequelize.define('teacher', {
        // Model attributes are defined here
        firstName: {
          type: DataTypes.STRING
        },
        lastName: {
          type: DataTypes.STRING
          // allowNull defaults to true
        },
        email: {
            type: DataTypes.STRING
            // allowNull defaults to true
        },
        password: {
            type: DataTypes.STRING
            // allowNull defaults to true
        }
      }, {
        // Other model options go here
        timestamps: false
      });

      module.exports = Teacher

      return Teacher
}