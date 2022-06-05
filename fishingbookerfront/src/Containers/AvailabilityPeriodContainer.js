import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import userServices from "../Services/UserServices/UserServices";
import ChangePasswordInstructorForm from "../Components/Common/ChangePasswordInstructorForm";
import AvailabilityPeriod from "../Components/Common/AvailabilityPeriod";

function AvailabilityPeriodContainer() {
  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));
  const [dateSpan, setDateSpan] = useState([]);

  function createDateSpan(dateSpan) {
    userServices
      .createDateSpan(dateSpan)
      .then((data) => {
        if (data.status === 204) setDateSpan([]);
        else {
          setDateSpan(data.data.content);
          console.log("sucessfuly added a datespan.");
          alert("sucessfuly added a datespan.");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <AvailabilityPeriod
        createDateSpanHandler={createDateSpan}
        logedInstructor={logedInstructor}
      ></AvailabilityPeriod>
      <Footerr></Footerr>
    </div>
  );
}

export default AvailabilityPeriodContainer;
