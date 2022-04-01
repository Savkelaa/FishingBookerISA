import React, { useEffect, useState } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import Login from "../Components/Common/Login";
import userServices from "../Services/UserServices/UserServices";
import { Link, Route, Switch, useHistory, useLocation } from "react-router-dom";

function LoginContainer() {
  const [client, setClient] = useState();
  const [admin, setAdmin] = useState();
  const [cottageOwner, setCottageOwner] = useState();
  const [boatOwner, setBoatOnwer] = useState();
  const [instructor, setInstructor] = useState();

  const history = useHistory();

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

              var clientt = JSON.parse(localStorage.getItem("Client"));
              if (Object.keys(clientt).length !== 0) {
                history.push("/userRegistration");
              }
            })

            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly logedOn a client");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  function logInAdmin(email, password) {
    userServices
      .logInAdmin(email, password)
      .then((data) => {
        if (data.status === 204) setAdmin();
        else {
          userServices
            .logInAdmin(email, password)
            .then((data) => {
              setAdmin(data.data);
              localStorage.setItem("Admin", JSON.stringify(data.data));
              var adminn = JSON.parse(localStorage.getItem("Admin"));
              if (Object.keys(adminn).length !== 0) {
                history.push("/adminHomePage");
              }
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly logedOn a admin");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  function logInCottageOwner(email, password) {
    userServices
      .logInCottageOwner(email, password)
      .then((data) => {
        if (data.status === 204) setCottageOwner();
        else {
          userServices
            .logInCottageOwner(email, password)
            .then((data) => {
              setCottageOwner(data.data);
              localStorage.setItem("Cottage Owner", JSON.stringify(data.data));
              var cottageOwnerr = JSON.parse(
                localStorage.getItem("Cottage Owner")
              );
              if (Object.keys(cottageOwnerr).length !== 0) {
                history.push("/adminHomePage"); //promenite kada napravite stranicu
              }
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly logedOn a cottage owner");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  function logInBoatOwner(email, password) {
    userServices
      .logInBoatOwner(email, password)
      .then((data) => {
        if (data.status === 204) setBoatOnwer();
        else {
          userServices
            .logInBoatOwner(email, password)
            .then((data) => {
              setBoatOnwer(data.data);
              localStorage.setItem("Boat Onwer", JSON.stringify(data.data));

              var boatOwnerr = JSON.parse(localStorage.getItem("Boat Owner"));
              if (Object.keys(boatOwnerr).length !== 0) {
                history.push("/adminHomePage"); //promenite kada napravite stranicu
              }
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly logedOn a BoatOnwer");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  function logInInstructor(email, password) {
    userServices
      .logInInstructor(email, password)
      .then((data) => {
        if (data.status === 204) setInstructor();
        else {
          userServices
            .logInInstructor(email, password)
            .then((data) => {
              setInstructor(data.data);
              localStorage.setItem("Instructor", JSON.stringify(data.data));
              var instructorr = JSON.parse(localStorage.getItem("Instructor"));
              if (Object.keys(instructorr).length !== 0) {
                history.push("/instructorHomePage");
              }
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly logedOn a instructor");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>

      <Login
        logInClientHandler={logInClient}
        logInAdminHandler={logInAdmin}
        logInInstructorHandler={logInInstructor}
        logInCottageOwnerHandler={logInCottageOwner}
        logInBoatOwnerHandler={logInBoatOwner}
      ></Login>
      <Footerr></Footerr>
    </div>
  );
}

export default LoginContainer;
