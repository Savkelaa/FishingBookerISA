import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";

import UserServices from "../Services/UserServices/UserServices";
import userServices from "../Services/UserServices/UserServices";
import RegistrationForm from "../Components/Common/RegistrationForm";
import ChangePasswordForm from "../Components/Common/ChangePasswordForm";

function ChangePasswordContainer() {
  const [admin, setAdmin] = useState([]);

  var logedAdmin = JSON.parse(localStorage.getItem("Admin"));
  const history = useHistory();

  function changePassword(admin) {
    userServices
      .changePassword(admin)
      .then((data) => {
        console.log("sucessfuly updated Admin");
        alert("Sucessfuly updated Admin password.");
        history.push("/adminHomePage");
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <ChangePasswordForm
        logedAdmin={logedAdmin}
        changePasswordHandler={changePassword}
      ></ChangePasswordForm>
      <Footerr></Footerr>
    </div>
  );
}

export default ChangePasswordContainer;
