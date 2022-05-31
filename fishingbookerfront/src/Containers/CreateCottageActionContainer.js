import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import CottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import CottageActionForm from "../Components/Common/CottageActionForm";

export default function CreateCottageActionContainer() {
  const [quickReservation, setQuickReservation] = useState();

  function createCottageQuickReservation(cottageAction) {
    CottageQuickReservationServices.createCottageQuickReservationAction(
      cottageAction
    )
      .then((data) => {
        if (data.status === 204) setQuickReservation();
        else {
          setQuickReservation(data.data);
          alert("sucessfuly added a quick Reservation action");
        }
      })
      .catch((error) => {
        alert("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CottageActionForm
        createCottageQuickReservationHandler={
          createCottageQuickReservation
        }
      ></CottageActionForm>
      <Footerr></Footerr>
    </div>
  );
}
