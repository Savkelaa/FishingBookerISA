import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import BoatQuickReservationServices from "../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import BoatActionForm from "../Components/Common/BoatActionForm";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";

export default function CreateBoatActionContainer() {
  const [quickReservation, setQuickReservation] = useState();
  const [tags, setTags] = useState([])

  function createBoatQuickReservation(boatAction) {
    BoatQuickReservationServices.createBoatQuickReservationAction(
      boatAction
    )
      .then((data) => {
        if (data.status === 204) setQuickReservation();
        else {
          setQuickReservation(data.data);
          alert("sucessfuly added a quick Reservation action");
        }
      })
      .catch((error) => {
        alert("Something wen't wrong try again", error);
      });
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
      <BoatActionForm
        createBoatQuickReservationHandler={
          createBoatQuickReservation
        }
        tags={tags}
        removeTags={removeTags}
        addTags={addTags}
      ></BoatActionForm>
      <Footerr></Footerr>
    </div>
  );
}
