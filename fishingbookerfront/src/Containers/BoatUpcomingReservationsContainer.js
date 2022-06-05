import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import boatQuickReservationServices from "../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import userServices from "../Services/UserServices/UserServices";
import BoatUpcomingReservations from "../Components/Common/BoatUpcomingReservations";

export default function BoatUpcomingReservationsContainer() {
  const [upcomingReservations, setUpcomingReservations] = useState([]);
  const [upcomingOrdReservations, setUpcomingOrdReservations] = useState([]);


  var logedOwner = JSON.parse(localStorage.getItem("BoatOwner"));

  useEffect(() => {
    boatQuickReservationServices
      .getAllBoatQuickReservationsByOwner(logedOwner.id)
      .then((data) => {
        setUpcomingReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));

      boatQuickReservationServices
      .getAllBoatReservationsByOwner(logedOwner.id)
      .then((data) => {
        setUpcomingOrdReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));



  }, []);



  return (
    <div>
      <Navbarr></Navbarr>
      <BoatUpcomingReservations
        upcomingReservations={upcomingReservations}
        upcomingOrdReservations={upcomingOrdReservations}
      ></BoatUpcomingReservations>
      <Footerr></Footerr>
    </div>
  );
}
