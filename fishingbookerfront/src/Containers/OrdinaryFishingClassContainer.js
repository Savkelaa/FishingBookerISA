import React, { useState, useEffect } from "react";
import CurrentReservations from "../Components/Common/OrdinaryFishingClass";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";

import boatService from "../Services/BoatServices/BoatServices";
import instructorService from "../Services/UserServices/UserServices"
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";


export default function CurrentReservationsContainer() {
  const [currentReservations, setCurrentReservations] = useState([]);
  

  useEffect(() => {
    fishingClassQuickReservationServices.getAllFishingClass()
      .then((data) => {
        setCurrentReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));

 
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <CurrentReservations
        currentReservations={currentReservations}
      ></CurrentReservations>
      <Footerr></Footerr>
    </div>
  );
}
