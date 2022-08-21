import React, { useState, useEffect } from "react";
import CurrentReservations from "../Components/Common/OrdinaryBoats";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";

import boatService from "../Services/BoatServices/BoatServices";


export default function CurrentReservationsContainer() {
  const [currentReservations, setCurrentReservations] = useState([]);
  

  useEffect(() => {
    boatService.getAllBoats()
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
