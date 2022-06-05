import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import userServices from "../Services/UserServices/UserServices";
import ChangePasswordInstructorForm from "../Components/Common/ChangePasswordInstructorForm";
import BoatAvailabilityPeriod from "../Components/Common/BoatAvailabilityPeriod";

function BoatAvailabilityPeriodContainer() {
  const [dateSpan, setDateSpan] = useState([]);

  function createDateSpan(dateSpan) {
    userServices
      .createDateSpanBoat(dateSpan)
      .then((data) => {
        if (data.status === 204) setDateSpan([]);
        else {
          setDateSpan(data.data.content);
          alert("sucessfuly added a datespan.");
        }
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <BoatAvailabilityPeriod
        createDateSpanHandler={createDateSpan}
      ></BoatAvailabilityPeriod>
      <Footerr></Footerr>
    </div>
  );
}

export default BoatAvailabilityPeriodContainer;
