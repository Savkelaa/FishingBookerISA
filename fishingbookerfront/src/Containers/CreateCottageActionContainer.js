import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import QuickReservationForm from "../Components/Common/QuickReservationForm";
import CottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import CottageActionForm from "../Components/Common/CottageActionForm";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";

export default function CreateCottageActionContainer() {
  const [quickReservation, setQuickReservation] = useState();
  const [tags, setTags] = useState([])

  function createCottageQuickReservation(cottageAction) {
    CottageQuickReservationServices.createCottageQuickReservationAction(
      cottageAction
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
      <CottageActionForm
        createCottageQuickReservationHandler={
          createCottageQuickReservation
        }
        tags={tags}
        removeTags={removeTags}
        addTags={addTags}
      ></CottageActionForm>
      <Footerr></Footerr>
    </div>
  );
}
