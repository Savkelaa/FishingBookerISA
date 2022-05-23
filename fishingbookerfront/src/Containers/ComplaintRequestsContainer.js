import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";

import rateServices from "../Services/RateServices/RateServices";
import RateRequests from "../Components/Common/RateRequests";
import complaintServices from "../Services/ComplaintServices/ComplaintServices";
import ComplaintRequests from "../Components/Common/ComplaintRequests";

export default function ComplaintRequestsContainer() {
  const [complaintRequests, setComplaintRequests] = useState([]);

  useEffect(() => {
    complaintServices
      .getAllInstructorComplaintRequests()
      .then((data) => {
        setComplaintRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function updateComplaint(complaint) {
    console.log("complaint", complaint);
    complaintServices
      .updateInstructorComplaint(complaint)
      .then((data) => {
        if (data.status === 204) setComplaintRequests([]);
        else {
          complaintServices
            .getAllInstructorComplaintRequests()
            .then((data) => {
              setComplaintRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a complaint requests");
          console.log("data.data", data.data);
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <ComplaintRequests
        complaintRequests={complaintRequests}
        updateComplaintHandler={updateComplaint}
      ></ComplaintRequests>
      <Footerr></Footerr>
    </div>
  );
}
