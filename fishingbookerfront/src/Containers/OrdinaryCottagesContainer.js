import React, { useState, useEffect } from "react";
import CurrentReservations from "../Components/Common/OrdinaryCottages";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import cottageService from "../Services/CottageServices/CottageServices";


export default function CurrentReservationsContainer() {
  const [currentReservations, setCurrentReservations] = useState([]);
  

  useEffect(() => {
   cottageService.getAllCottages()
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
