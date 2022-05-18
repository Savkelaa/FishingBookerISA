import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import userServices from "../Services/UserServices/UserServices";
import ChangePasswordInstructorForm from "../Components/Common/ChangePasswordInstructorForm";
import AvailabilityPeriod from "../Components/Common/AvailabilityPeriod";

function AvailabilityPeriodContainer() {
  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  function updateInstructor(instructor) {
    userServices
      .updateInstructor(instructor)
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
      <AvailabilityPeriod
        updateInstructorHandler={updateInstructor}
        logedInstructor={logedInstructor}
      ></AvailabilityPeriod>
      <Footerr></Footerr>
    </div>
  );
}

export default AvailabilityPeriodContainer;
