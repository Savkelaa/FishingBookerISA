import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router";
import cottageServices from "../Services/CottageServices/CottageServices";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";
import { Nav, Navbar, NavbarBrand, NavDropdown, Table } from "react-bootstrap";
import Card from "react-bootstrap/Card";
import background from "../Assets/img/background.jpg";
import "../App.css";
import Profile from "../Components/Common/Profile";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";

export default function FishingClassContainer() {
  return (
    <div
      style={{
        backgroundImage: `url(${background})`,
        backgroundPosition: "center",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
      }}
    >
      <Navbarr></Navbarr>

      <Profile></Profile>
      <Footerr></Footerr>
    </div>
  );
}
