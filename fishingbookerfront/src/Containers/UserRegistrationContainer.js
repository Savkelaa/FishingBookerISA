import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";

import UserServices from "../Services/UserServices/UserServices";
import userServices from "../Services/UserServices/UserServices";
import RegistrationForm from "../Components/Common/RegistrationForm";

function UserRegistrationContainer() {
  const [user, setUser] = useState([]);
  const [boatOwner, setBoatOwner] = useState([]);
  const [instructor, setInstructor] = useState([]);
  const [cottageOwner, setCottageOwner] = useState([]);

  /* function addUser(user) {
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
  }*/

  function addClient(user) {
    userServices
      .createClient(user)
      .then((data) => {
        if (data.status === 204) setUser([]);
        else {
          setUser(data.data.content);
          console.log("sucessfuly added a client");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
        console.log("Something wen't wrong try again");
      });
  }

  function addBoatOwner(boatOwner) {
    userServices
      .createBoatOwner(boatOwner)
      .then((data) => {
        if (data.status === 204) setBoatOwner([]);
        else {
          setBoatOwner(data.data.content);
          console.log("sucessfuly added a boat Owner");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
        console.log("Something wen't wrong try again");
      });
  }

  function addInstructor(instrictor) {
    userServices
      .createInstructor(instrictor)
      .then((data) => {
        if (data.status === 204) setInstructor([]);
        else {
          setInstructor(data.data.content);
          console.log("sucessfuly added a instructor");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
        console.log("Something wen't wrong try again");
      });
  }

  function addCottageOwner(cottageOwner) {
    userServices
      .createCottageOwner(cottageOwner)
      .then((data) => {
        if (data.status === 204) setCottageOwner([]);
        else {
          setCottageOwner(data.data.content);
          console.log("sucessfuly added a cottage owner.");
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
      <RegistrationForm
        addClientHandler={addClient}
        addCottageOwnerHandler={addCottageOwner}
        addInstructorHandler={addInstructor}
        addBoatOwnerHandler={addBoatOwner}
      ></RegistrationForm>
      <Footerr></Footerr>
    </div>
  );
}

export default UserRegistrationContainer;
