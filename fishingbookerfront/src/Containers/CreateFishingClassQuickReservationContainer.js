import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import FishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";

export default function CreateFishingClassQuickReservationContainer() {
  const [quickReservation, setQuickReservation] = useState();
  // const [allAdditionalServices, setAdditionalServices] = useState([]);
  const [tags, setTags] = useState([]);
  const [reservations, setReservations] = useState([]);

  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  function createFishingClassQuickReservation(quickReservation) {
    function myFunction(reservation) {
      var x = 1;
      var startDateReservation = new Date(reservation.startDate);
      var endDateReservation = new Date(reservation.finishDate);
      var startDateReservationAction = new Date(reservation.startDateAction);
      var endDateReservationAction = new Date(reservation.finishDateAction);
      console.log("startDateReservation", startDateReservation);
      console.log("endDateReservation", endDateReservation);
      console.log("startDateReservationAction", startDateReservationAction);
      console.log("endDateReservationAction", endDateReservationAction);

      if (
        startDateReservation < endDateReservation &&
        startDateReservationAction < endDateReservationAction
      ) {
        console.log("NE PREKLAPA");
      } else {
        console.log("PREKLAPA");
        x = 0;
      }

      return x;
    }

    let x = myFunction(quickReservation);
    if (x == 0) {
      alert(" the start date is later than the last day");
    }
    if (x != 0) {
      FishingClassQuickReservationServices.createFishingClassQuickReservation(
        quickReservation
      )
        .then((data) => {
          if (data.status === 204) setQuickReservation();
          else {
            setQuickReservation(data.data);
            console.log("sucessfuly added a quickReservation", data.data);
            alert("sucessfuly added a quickReservation");
          }
        })
        .catch((error) => {
          alert("Something wen't wrong try again", error);
        });
    }
  }

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllAdditionalServiceNames()
      .then((data) => {
        setTags(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  const removeTags = (indexToRemove) => {
    setTags([...tags.filter((_, index) => index !== indexToRemove)]);
  };
  const addTags = (event) => {
    if (event.target.value !== "") {
      setTags([...tags, event.target.value]);
      //  props.selectedTags([...tags, event.target.value]);

      event.target.value = "";
    }
  };

  return (
    <div>
      <Navbarr></Navbarr>
      <QuickReservationForm
        createFishingClassQuickReservationHandler={
          createFishingClassQuickReservation
        }
        //allAdditionalServices={allAdditionalServices}
        tags={tags}
        removeTags={removeTags}
        addTags={addTags}
      ></QuickReservationForm>
      <Footerr></Footerr>
    </div>
  );
}
