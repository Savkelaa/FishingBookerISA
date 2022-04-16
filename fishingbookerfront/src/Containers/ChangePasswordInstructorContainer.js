import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import userServices from "../Services/UserServices/UserServices";
import ChangePasswordInstructorForm from "../Components/Common/ChangePasswordInstructorForm";

function ChangePasswordInstructorContainer() {
  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  function changePasswordInstructor(instructor) {
    userServices
      .changePasswordInstructor(instructor)
      .then((data) => {
        console.log("sucessfuly updated instructor");
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <ChangePasswordInstructorForm
        logedInstructor={logedInstructor}
        changePasswordInstructorHandler={changePasswordInstructor}
      ></ChangePasswordInstructorForm>
      <Footerr></Footerr>
    </div>
  );
}

export default ChangePasswordInstructorContainer;
