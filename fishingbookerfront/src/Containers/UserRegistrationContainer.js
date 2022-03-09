import React from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import ReservationForm from "../Components/Common/QuickReservationForm";

function UserRegistrationContainer() {
  return (
    <div>
      <Navbarr></Navbarr>
      <ReservationForm></ReservationForm>
      <Footerr></Footerr>
    </div>
  );
}

export default UserRegistrationContainer;
