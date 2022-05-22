import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";

import rateServices from "../Services/RateServices/RateServices";
import RateRequests from "../Components/Common/RateRequests";

export default function RateRequestsContainer() {
  const [fishingClassRateRequests, setfishingClassRateRequests] = useState([]);
  const [instructorRateRequests, setInstructorRateRequests] = useState([]);

  useEffect(() => {
    rateServices
      .getAllFishingClassRateRequests()
      .then((data) => {
        setfishingClassRateRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    rateServices
      .getAllInstructorRateRequests()
      .then((data) => {
        setInstructorRateRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function updateFishingClassRate(rate) {
    console.log("rate", rate);
    rateServices
      .updateFishingClassRate(rate)
      .then((data) => {
        if (data.status === 204) setfishingClassRateRequests([]);
        else {
          rateServices
            .getAllFishingClassRateRequests()
            .then((data) => {
              setfishingClassRateRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a fishingClass requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function updateInstructorRate(rate) {
    console.log("rate", rate);
    rateServices
      .updateInstructorRate(rate)
      .then((data) => {
        if (data.status === 204) setInstructorRateRequests([]);
        else {
          rateServices
            .getAllInstructorRateRequests()
            .then((data) => {
              setInstructorRateRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a instructor requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <RateRequests
        fishingClassRateRequests={fishingClassRateRequests}
        instructorRateRequests={instructorRateRequests}
        updateFishingClassRateHandler={updateFishingClassRate}
        updateInstructorRateHandler={updateInstructorRate}
      ></RateRequests>
      <Footerr></Footerr>
    </div>
  );
}
