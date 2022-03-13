import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import ReservationForm from "../Components/Common/QuickReservationForm";
import UserServices from "../Services/UserServices/UserServices";
import userServices from "../Services/UserServices/UserServices";

function UserRegistrationContainer() {
  const [user, setUser] = useState([]);

  function addUser(user) {
    userServices
      .signUpUser(user)
      .then((data) => {
        if (data.status === 204) setUser([]);
        else {
          console.log("sucessfuly added a user");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <ReservationForm user={user}></ReservationForm>
      <Footerr></Footerr>
    </div>
  );
}

export default UserRegistrationContainer;
