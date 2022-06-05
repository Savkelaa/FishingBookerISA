import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import userServices from "../Services/UserServices/UserServices";
import RegistrationForm from "../Components/Common/RegistrationForm";
import AdminRegistrationForm from "../Components/Common/AdminRegistrationForm";

function UserRegistrationContainer() {
  const [admin, setAdmin] = useState([]);

  function addAdmin(user) {
    userServices
      .createAdmin(user)
      .then((data) => {
        if (data.status === 204) setAdmin([]);
        else {
          setAdmin(data.data.content);
          console.log("sucessfuly added a admin");
          alert("sucessfuly added a admin");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <AdminRegistrationForm addAdminHandler={addAdmin}></AdminRegistrationForm>
      <Footerr></Footerr>
    </div>
  );
}

export default UserRegistrationContainer;
