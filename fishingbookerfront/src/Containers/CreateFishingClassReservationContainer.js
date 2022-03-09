import React from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";

export default function CreateFishingClassReservationContainer() {
  return (
    <div>
      <Navbarr></Navbarr>
      <QuickReservationForm></QuickReservationForm>
      <Footerr></Footerr>
    </div>
  );
}
