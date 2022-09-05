import React from "react";
import { Nav, Navbar, NavbarBrand, NavDropdown, Table } from "react-bootstrap";
import logo from "../../Assets/img/logo.jpg";
import { useHistory } from "react-router-dom";
export default function Navbarr() {
  const navigate=useHistory()
  return (
    <Navbar bg="dark" variant="dark" sticky="top">
      <NavbarBrand className="brand" expand="lg">
        <img src={logo} height="30px" width="50px" margin="auto" />
        FishingBooker
      </NavbarBrand>
      <Navbar.Toggle className="coloring" />
      <Nav>
        <Nav.Link onClick={()=>{navigate.push("/clientHomePage")}} >Home Page</Nav.Link>
      

        <NavDropdown title="Service">
          <NavDropdown.Item onClick={()=>{navigate.push("/allInstructors")}}  >
            Instructors
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item onClick={()=>{navigate.push("/allCottages")}} >
            Cottages
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/allBoats")}}  >
            Boats
          </NavDropdown.Item>
        </NavDropdown>

        <NavDropdown title="History of reservations">
          <NavDropdown.Item onClick={()=>{navigate.push("/cottageOrdinaryReservationHistory")}} >
            Cottage
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/boatOrdinaryReservationHistory")}}>
            Boat
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/fishingClassOrdinaryReservationHistory")}} >
            FishingClass
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item onClick={()=>{navigate.push("/cottageReservationHistoryByClient")}} >
            QuickCottage
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/boatReservationHistoryClient")}} >
            QuickBoat
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/fishingClassReservationHistoryByClient")}} >
            QuickFishingClass
          </NavDropdown.Item>
        </NavDropdown>


        <NavDropdown title="Future reservations">
          <NavDropdown.Item onClick={()=>{navigate.push("/cottageOrdinaryReservationsFuture")}} >
            Cottage
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/boatOrdinaryReservationsFuture")}} >
            Boat
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/fishingClassOrdinaryReservationsFuture")}} >
            FishingClass
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item onClick={()=>{navigate.push("/cottageQuickReservationsFuture")}} >
            QuickCottage
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/boatQuickReservationsFuture")}} >
            QuickBoat
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/fishingClassQuickReservationsFuture")}} >
            QuickFishingClass
          </NavDropdown.Item>
        </NavDropdown>

        <NavDropdown title="All reservations">
          <NavDropdown.Item onClick={()=>{navigate.push("/OrdinaryCottageReservationAll")}} >
            Cottage
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/OrdinaryBoatReservationAll")}} >
            Boat
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/OrdinaryFishingClassReservationAll")}} >
            FishingClass
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item onClick={()=>{navigate.push("/cottageReservationClientAll")}} >
            QuickCottage
          </NavDropdown.Item>
          <NavDropdown.Item onClick={()=>{navigate.push("/boatReservationClientAll")}} >
            QuickBoat
          </NavDropdown.Item>
          {/* <NavDropdown.Item href="fishingClassReservationClientAll">
            QuickFishingClass
          </NavDropdown.Item> */}
          <NavDropdown.Item onClick={()=>{navigate.push("/fishingClassReservationClientAll")}}>
            QuickFishingClass
          </NavDropdown.Item>
        </NavDropdown>

        <Nav.Link href="login">Logout</Nav.Link>
      </Nav>
    </Navbar>
  );
}
