import React, { useState, useEffect} from "react";
import { useParams } from "react-router";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import CottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import CreateCottageReservation from "../Components/Common/CreateCottageReservation2";

export default function CreateCottageReservationContainer() {
 
  const [reservation, setReservation] = useState();
  const [reservations, setReservations] = useState([]);
  console.log("reservations", reservations);
  var logedCottageOwner = JSON.parse(localStorage.getItem("CottageOwner"));
  
  let { id } = useParams();

  function createCottageReservation(reservation) {
   

    var x=1;

    if (x != 0) {
      CottageQuickReservationServices.createCottageReservation(
        reservation
      )
        .then((data) => {
          if (data.status === 204) setReservation();
          else {
            setReservation(data.data);
            console.log("sucessfuly added a reservation");
            alert("sucessfuly added a reservation");
          }
        })
        .catch((error) => {
          alert("Something wen't wrong try again", error);
        });
    }
  }

  useEffect(() => {
    CottageQuickReservationServices
      .getCottageQuickReservationByCottage(id)
      .then((data) => {
        setReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <CreateCottageReservation
        createCottageReservationHandler={createCottageReservation}
      ></CreateCottageReservation>
      <Footerr></Footerr>
    </div>
  );
}
