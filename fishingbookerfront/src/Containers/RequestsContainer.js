import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import Request from "../Components/Common/Request";
import userServices from "../Services/UserServices/UserServices";

export default function RequestsContainer() {
  const [instructorRequests, setInstructorRequests] = useState([]);
  const [boatOwnerRequests, setBoatOwnerRequests] = useState([]);
  const [cottageOwnerRequests, setCottageOwnerRequests] = useState([]);

  const [clientRequests, setClientRequests] = useState([]);

  const [cottageOwner, setCottageOwner] = useState({});

  useEffect(() => {
    userServices
      .getAllInstructorRequests()
      .then((data) => {
        setInstructorRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllBoatOwnerRequests()
      .then((data) => {
        setBoatOwnerRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllCottageOwnerRequests()
      .then((data) => {
        setCottageOwnerRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllClientRequests()
      .then((data) => {
        setClientRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function activateClient(client) {
    userServices
      .activateClient(client)
      .then((data) => {
        if (data.status === 204) setClientRequests([]);
        else {
          userServices
            .getAllClientRequests()
            .then((data) => {
              setClientRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a Client requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function removeClient(client) {
    userServices
      .removeClient(client)
      .then((data) => {
        if (data.status === 204) setClientRequests([]);
        else {
          userServices
            .getAllClientRequests()
            .then((data) => {
              setClientRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a Client requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function activateCottageOwner(cottageOwner) {
    userServices
      .activateCottageOwner(cottageOwner)
      .then((data) => {
        if (data.status === 204) setCottageOwnerRequests([]);
        else {
          userServices
            .getAllCottageOwnerRequests()
            .then((data) => {
              setCottageOwnerRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a CottageOwner requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function removeCottageOwner(cottageOwner) {
    userServices
      .removeCottageOwner(cottageOwner)
      .then((data) => {
        if (data.status === 204) setCottageOwnerRequests([]);
        else {
          userServices
            .getAllCottageOwnerRequests()
            .then((data) => {
              setCottageOwnerRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a CottageOwner requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function activateBoatOwner(boatOwner) {
    userServices
      .activateBoatOwner(boatOwner)
      .then((data) => {
        if (data.status === 204) setBoatOwnerRequests([]);
        else {
          userServices
            .getAllBoatOwnerRequests()
            .then((data) => {
              setBoatOwnerRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a BoatOwner requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function removeBoatOwner(boatOwner) {
    userServices
      .removeBoatOwner(boatOwner)
      .then((data) => {
        if (data.status === 204) setBoatOwnerRequests([]);
        else {
          userServices
            .getAllBoatOwnerRequests()
            .then((data) => {
              setBoatOwnerRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a BoatOwner requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function activateInstructor(instructor) {
    userServices
      .activateInstructor(instructor)
      .then((data) => {
        if (data.status === 204) setInstructorRequests([]);
        else {
          userServices
            .getAllInstructorRequests()
            .then((data) => {
              setInstructorRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a instructor requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function removeInstructor(instructor) {
    userServices
      .removeInstructor(instructor)
      .then((data) => {
        if (data.status === 204) setInstructorRequests([]);
        else {
          userServices
            .getAllInstructorRequests()
            .then((data) => {
              setInstructorRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly updated a instructor requests");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <Request
        instructorRequests={instructorRequests}
        boatOwnerRequests={boatOwnerRequests}
        cottageOwnerRequests={cottageOwnerRequests}
        clientRequests={clientRequests}
        activateClientHandler={activateClient}
        activateCottageOwnerHandler={activateCottageOwner}
        activateBoatOwnerHandler={activateBoatOwner}
        activateInstructorHandler={activateInstructor}
        removeClientHandler={removeClient}
        removeCottageOwnerHandler={removeCottageOwner}
        removeBoatOwnerHandler={removeBoatOwner}
        removeInstructorHandler={removeInstructor}
      ></Request>
      <Footerr></Footerr>
    </div>
  );
}
