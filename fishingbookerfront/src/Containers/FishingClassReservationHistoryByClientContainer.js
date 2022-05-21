import React, { useState, useEffect } from "react";
import CurrentReservations from "../Components/Common/CurrentReservations";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import FishingClassReservationHistory from "../Components/Common/FishingClassReservationHistory";
import FishingClassReservationHistoryByClient from "../Components/Common/FishingClassReservationHistoryByClient";

export default function FishingClassReservationHistoryByClientContainer() {
  const [reservationHistory, setReservationHistory] = useState([]);
  const [fishingClassRates, setFishingClassRates] = useState([]);
  const [instructorRates, setInstructorRates] = useState([]);

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllFishingClassReservationsByClient(1)
      .then((data) => {
        setReservationHistory(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function addFishingClassRate(rate) {
    fishingClassQuickReservationServices
      .createFishingClassRate(rate)
      .then((data) => {
        if (data.status === 204) setFishingClassRates([]);
        else {
          setFishingClassRates(data.data.content);
          console.log("sucessfuly added a rate for fishing Class.");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function addInstructorRate(rate) {
    fishingClassQuickReservationServices
      .createInstructorRate(rate)
      .then((data) => {
        if (data.status === 204) setInstructorRates([]);
        else {
          setInstructorRates(data.data.content);
          console.log("sucessfuly added a rate for instructor.");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <FishingClassReservationHistoryByClient
        reservationHistory={reservationHistory}
        addInstructorRateHandler={addInstructorRate}
        addFishingClassRateHandler={addFishingClassRate}
      ></FishingClassReservationHistoryByClient>
      <Footerr></Footerr>
    </div>
  );
}
