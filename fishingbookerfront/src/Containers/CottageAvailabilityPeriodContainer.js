import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import userServices from "../Services/UserServices/UserServices";
import ChangePasswordInstructorForm from "../Components/Common/ChangePasswordInstructorForm";
import CottageAvailabilityPeriod from "../Components/Common/CottageAvailabilityPeriod";

function CottageAvailabilityPeriodContainer() {
  const [dateSpan, setDateSpan] = useState([]);

  function createDateSpan(dateSpan) {
    userServices
      .createDateSpanCottage(dateSpan)
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
      <CottageAvailabilityPeriod
        createDateSpanHandler={createDateSpan}
      ></CottageAvailabilityPeriod>
      <Footerr></Footerr>
    </div>
  );
}

export default CottageAvailabilityPeriodContainer;
