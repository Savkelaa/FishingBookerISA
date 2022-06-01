import React, { useState, useEffect } from "react";
import CurrentReservations from "../Components/Common/CurrentReservations";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";

export default function CurrentReservationsContainer() {
  const [currentReservations, setCurrentReservations] = useState([]);
  const [currentQuickReservations, setCurrentQuickReservations] = useState([]);

  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllFishingClassReservationsByInstructor(logedInstructor.id)
      .then((data) => {
        setCurrentReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getAllFishingClassQuickReservationsByInstructor(logedInstructor.id)
      .then((data) => {
        setCurrentQuickReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <CurrentReservations
        currentReservations={currentReservations}
        currentQuickReservations={currentQuickReservations}
      ></CurrentReservations>
      <Footerr></Footerr>
    </div>
  );
}
