import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";

import UserServices from "../Services/UserServices/UserServices";
import userServices from "../Services/UserServices/UserServices";
import RegistrationForm from "../Components/Common/RegistrationForm";
import CreateLoyaltyCategory from "../Components/Common/CreateLoyaltyCategory";

function CreateLoyaltyCategoryContainer() {
  const [category, setCategory] = useState([]);

  function addCategory(category) {
    userServices
      .createLoyaltyCategory(category)
      .then((data) => {
        if (data.status === 204) setCategory([]);
        else {
          setCategory(data.data.content);
          console.log("sucessfuly added a category");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CreateLoyaltyCategory
        addCategoryHandler={addCategory}
      ></CreateLoyaltyCategory>
      <Footerr></Footerr>
    </div>
  );
}

export default CreateLoyaltyCategoryContainer;
