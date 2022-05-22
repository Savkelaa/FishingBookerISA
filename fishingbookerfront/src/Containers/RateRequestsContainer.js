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

  return (
    <div>
      <Navbarr></Navbarr>
      <RateRequests
        fishingClassRateRequests={fishingClassRateRequests}
        instructorRateRequests={instructorRateRequests}
      ></RateRequests>
      <Footerr></Footerr>
    </div>
  );
}
