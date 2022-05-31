import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import cottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import CottageCurrentReservations from "../Components/Common/CottageCurrentReservations";

export default function CottageCurrentReservationsContainer() {
  const [currentReservations, setCurrentReservations] = useState([]);

  var logedOwner = JSON.parse(localStorage.getItem("CottageOwner"));

  useEffect(() => {
    cottageQuickReservationServices
      .getAllCottageQuickReservationsByOwner(logedOwner.id)
      .then((data) => {
        setCurrentReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <CottageCurrentReservations
        currentReservations={currentReservations}
      ></CottageCurrentReservations>
      <Footerr></Footerr>
    </div>
  );
}
