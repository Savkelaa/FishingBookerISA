import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";

import rateServices from "../Services/RateServices/RateServices";
import RateRequests from "../Components/Common/RateRequests";
import NavbarAdmin from "../Components/Common/NavbarAdmin";

export default function RateRequestsContainer() {
  const [fishingClassRateRequests, setfishingClassRateRequests] = useState([]);
  const [instructorRateRequests, setInstructorRateRequests] = useState([]);

  const [cottageRateRequests, setcottageRateRequests] = useState([]);
  const [cottageOwnerRateRequests, setcottageOwnerRateRequests] = useState([]);

  const [boatRateRequests, setboatRateRequests] = useState([]);
  const [boatOwnerRateRequests, setboatOwnerRateRequests] = useState([]);

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

    rateServices
      .getAllCottageRateRequests()
      .then((data) => {
        setcottageRateRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    rateServices
      .getAllCottageOwnerRateRequests()
      .then((data) => {
        setcottageOwnerRateRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    rateServices
      .getAllBoatRateRequests()
      .then((data) => {
        setboatRateRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    rateServices
      .getAllBoatOwnerRateRequests()
      .then((data) => {
        setboatOwnerRateRequests(data.data);
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
          alert("sucessfuly updated a fishingClass requests");
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
          alert("sucessfuly updated a instructor requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function updateCottageRate(rate) {
    console.log("rate", rate);
    rateServices
      .updateCottageRate(rate)
      .then((data) => {
        if (data.status === 204) setcottageRateRequests([]);
        else {
          rateServices
            .getAllCottageRateRequests()
            .then((data) => {
              setcottageRateRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a cottage rate requests");
          alert("sucessfuly updated a cottage rate requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function updateCottageOwnerRate(rate) {
    console.log("rate", rate);
    rateServices
      .updateCottageOwnerRate(rate)
      .then((data) => {
        if (data.status === 204) setcottageOwnerRateRequests([]);
        else {
          rateServices
            .getAllCottageOwnerRateRequests()
            .then((data) => {
              setcottageOwnerRateRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a cottage owner requests");
          alert("sucessfuly updated a cottage rate requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function updateBoatRate(rate) {
    console.log("rate", rate);
    rateServices
      .updateBoatRate(rate)
      .then((data) => {
        if (data.status === 204) setboatRateRequests([]);
        else {
          rateServices
            .getAllBoatRateRequests()
            .then((data) => {
              setboatRateRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a baot rate requests");
          alert("sucessfuly updated a baot rate requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function updateBoatOwnerRate(rate) {
    console.log("rate", rate);
    rateServices
      .updateBoatOwnerRate(rate)
      .then((data) => {
        if (data.status === 204) setboatOwnerRateRequests([]);
        else {
          rateServices
            .getAllBoatOwnerRateRequests()
            .then((data) => {
              setboatOwnerRateRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a boat owner requests");
          alert("sucessfuly updated a baot rate requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <NavbarAdmin></NavbarAdmin>
      <RateRequests
        fishingClassRateRequests={fishingClassRateRequests}
        instructorRateRequests={instructorRateRequests}
        updateFishingClassRateHandler={updateFishingClassRate}
        updateInstructorRateHandler={updateInstructorRate}
        cottageRateRequests={cottageRateRequests}
        cottageOwnerRateRequests={cottageOwnerRateRequests}
        updateCottageRateHandler={updateCottageRate}
        updateCottageOwnerRateHandler={updateCottageOwnerRate}
        boatRateRequests={boatRateRequests}
        boatOwnerRateRequests={boatOwnerRateRequests}
        updateBoatRateHandler={updateBoatRate}
        updateBoatOwnerRateHandler={updateBoatOwnerRate}
      ></RateRequests>
      <Footerr></Footerr>
    </div>
  );
}
