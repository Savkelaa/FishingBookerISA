import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";

import UserServices from "../Services/UserServices/UserServices";
import userServices from "../Services/UserServices/UserServices";
import RegistrationForm from "../Components/Common/RegistrationForm";
import ChangePasswordBoatOwnerForm from "../Components/Common/ChangePasswordBoatOwnerForm";

function ChangePasswordBoatOwnerContainer() {
  const [boatOwner, setBoatOwner] = useState([]);

  var logedBoatOwner = JSON.parse(localStorage.getItem("BoatOwner"));

  function changePassword(boatOwner) {
    userServices
      .changePasswordBoatOwner(boatOwner)
      .then((data) => {
        alert("sucessfuly updated BoatOwner");
      })
      .catch((error) => {
        alert("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <ChangePasswordBoatOwnerForm
        logedBoatOwner={logedBoatOwner}
        changePasswordHandler={changePassword}
      ></ChangePasswordBoatOwnerForm>
      <Footerr></Footerr>
    </div>
  );
}

export default ChangePasswordBoatOwnerContainer;
