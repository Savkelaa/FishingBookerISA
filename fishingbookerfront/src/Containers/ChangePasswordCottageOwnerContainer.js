import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";

import UserServices from "../Services/UserServices/UserServices";
import userServices from "../Services/UserServices/UserServices";
import RegistrationForm from "../Components/Common/RegistrationForm";
import ChangePasswordCottageOwnerForm from "../Components/Common/ChangePasswordCottageOwnerForm";

function ChangePasswordCottageOwnerContainer() {
  const [cottageOwner, setCottageOwner] = useState([]);

  var logedCottageOwner = JSON.parse(localStorage.getItem("CottageOwner"));

  function changePassword(cottageOwner) {
    userServices
      .changePasswordCottageOwner(cottageOwner)
      .then((data) => {
        alert("sucessfuly updated CottageOwner");
      })
      .catch((error) => {
        alert("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <ChangePasswordCottageOwnerForm
        logedCottageOwner={logedCottageOwner}
        changePasswordHandler={changePassword}
      ></ChangePasswordCottageOwnerForm>
      <Footerr></Footerr>
    </div>
  );
}

export default ChangePasswordCottageOwnerContainer;
