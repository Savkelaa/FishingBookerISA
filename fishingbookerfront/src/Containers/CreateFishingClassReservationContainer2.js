import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import FishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import CreateFishingClassReservation from "../Components/Common/CreateFishingClassReservation2";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import { useParams } from "react-router-dom";

export default function CreateFishingClassReservationContainer() {
  const [reservation, setReservation] = useState();
  const [reservations, setReservations] = useState([]);
  console.log("reservations", reservations);
  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));
  let { id } = useParams();
  const [tags, setTags] = useState([]);

  function createFishingClassReservation(reservation) {


    let x = 1


    if (x != 0) {
      FishingClassQuickReservationServices.createFishingClassReservation(
        reservation
      )
        .then((data) => {
          if (data.status === 204) setReservation();
          else {
            setReservation(data.data);
            console.log("sucessfuly added a reservation");
            alert("sucessfuly added a reservation");
            fishingClassQuickReservationServices
              .getAllFishingClassReservationsByInstructor(logedInstructor.id)
              .then((data) => {
                setReservations(data.data);
              })
              .catch((error) => console.log(`error`, error));
          }
        })
        .catch((error) => {
          alert("Something wen't wrong try again", error);
        });
    }
  }

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllFishingClassReservationsFree()
      .then((data) => {
        setReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));

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
      <CreateFishingClassReservation
        createFishingClassReservationHandler={createFishingClassReservation}
        tags={tags}
        removeTags={removeTags}
        addTags={addTags}
      ></CreateFishingClassReservation>
      <Footerr></Footerr>
    </div>
  );
}