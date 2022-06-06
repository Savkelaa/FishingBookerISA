import React, { useState, useEffect} from "react";
import { useParams } from "react-router";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import CottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import CreateCottageReservation from "../Components/Common/CreateCottageReservation";

export default function CreateCottageReservationContainer() {
 
  const [reservation, setReservation] = useState();
  const [reservations, setReservations] = useState([]);
  console.log("reservations", reservations);
  var logedCottageOwner = JSON.parse(localStorage.getItem("CottageOwner"));
  let { id } = useParams();

  function createCottageReservation(reservation) {
    function myFunction(reservation) {
      var x = 1;
      var startDateReservation = new Date(reservation.startDate);
      var endDateReservation = new Date(reservation.finishDate);
      reservations.forEach((reservationn) => {
        var startDate = new Date(reservationn.startDate);
        var endDate = new Date(reservationn.finishDate);
        console.log("startDate", startDate);
        console.log("endDate", endDate);
        console.log("startDateReservation", startDateReservation);
        console.log("endDateReservation", endDateReservation);

        if (startDateReservation > endDate || endDateReservation < startDate) {
          console.log("NE PREKLAPA");
        } else {
          console.log("PREKLAPA");
          x = 0;
        }
      });
      return x;
    }

    let x = myFunction(reservation);
    if (x == 0) {
      alert("your reservation overlaps with other reservations");
    }

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
