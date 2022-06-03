import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import cottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import CottageUpcomingReservations from "../Components/Common/CottageUpcomingReservations";

export default function CottageUpcomingReservationsContainer() {
  const [upcomingReservations, setUpcomingReservations] = useState([]);
  const [upcomingOrdReservations, setUpcomingOrdReservations] = useState([]);


  var logedOwner = JSON.parse(localStorage.getItem("CottageOwner"));

  useEffect(() => {
    cottageQuickReservationServices
      .getAllCottageQuickReservationsByOwner(logedOwner.id)
      .then((data) => {
        setUpcomingReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));

      cottageQuickReservationServices
      .getAllCottageReservationsByOwner(logedOwner.id)
      .then((data) => {
        setUpcomingOrdReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));



  }, []);



  return (
    <div>
      <Navbarr></Navbarr>
      <CottageUpcomingReservations
        upcomingReservations={upcomingReservations}
        upcomingOrdReservations={upcomingOrdReservations}
      ></CottageUpcomingReservations>
      <Footerr></Footerr>
    </div>
  );
}
