import React, { useEffect, useState } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import Login from "../Components/Common/Login";
import userServices from "../Services/UserServices/UserServices";
import { Link } from "react-router-dom";

function LoginContainer() {
  const [client, setClient] = useState();

  function logInClient(email, password) {
    userServices
      .logInClient(email, password)
      .then((data) => {
        if (data.status === 204) setClient();
        else {
          userServices
            .logInClient(email, password)
            .then((data) => {
              setClient(data.data);
              localStorage.setItem("Client", JSON.stringify(data.data));
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly logedOn a client");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <Login logInClientHandler={logInClient}></Login>
      <Footerr></Footerr>
    </div>
  );
}

export default LoginContainer;
