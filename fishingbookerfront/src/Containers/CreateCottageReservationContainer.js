import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import CottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import CreateCottageReservation from "../Components/Common/CreateCottageReservation";

export default function CreateCottageReservationContainer() {
  const [reservation, setReservation] = useState();

  function createCottageReservation(reservation) {
    CottageQuickReservationServices.createCottageReservation(reservation)
      .then((data) => {
        if (data.status === 204) setReservation();
        else {
          setReservation(data.data);
          alert("sucessfuly added a reservation");
        }
      })
      .catch((error) => {
        alert("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CreateCottageReservation
        createCottageReservationHandler={createCottageReservation}
      ></CreateCottageReservation>
      <Footerr></Footerr>
    </div>
  );
}
