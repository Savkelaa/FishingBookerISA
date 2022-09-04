import React from "react";
import { Nav, Navbar, NavbarBrand, NavDropdown, Table } from "react-bootstrap";
import logo from "../../Assets/img/logo.jpg";

export default function Navbarr() {
  return (
    <Navbar bg="dark" variant="dark" sticky="top">
      <NavbarBrand className="brand" expand="lg">
        <img src={logo} height="30px" width="50px" margin="auto" />
        FishingBooker
      </NavbarBrand>
      <Navbar.Toggle className="coloring" />
      <Nav>
        <Nav.Link href="clientHomePage">Home Page</Nav.Link>
      

        <NavDropdown title="Service">
          <NavDropdown.Item href="allInstructors">
            Instructors
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="allCottages">
            Cottages
          </NavDropdown.Item>
          <NavDropdown.Item href="allBoats">
            Boats
          </NavDropdown.Item>
        </NavDropdown>

        <NavDropdown title="History of reservations">
          <NavDropdown.Item href="cottageOrdinaryReservationHistory">
            Cottage
          </NavDropdown.Item>
          <NavDropdown.Item href="boatOrdinaryReservationHistory">
            Boat
          </NavDropdown.Item>
          <NavDropdown.Item href="fishingClassOrdinaryReservationHistory">
            FishingClass
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="cottageReservationHistoryByClient">
            QuickCottage
          </NavDropdown.Item>
          <NavDropdown.Item href="boatReservationHistoryClient">
            QuickBoat
          </NavDropdown.Item>
          <NavDropdown.Item href="fishingClassReservationHistoryByClient">
            QuickFishingClass
          </NavDropdown.Item>
        </NavDropdown>


        <NavDropdown title="Future reservations">
          <NavDropdown.Item href="cottageOrdinaryReservationsFuture">
            Cottage
          </NavDropdown.Item>
          <NavDropdown.Item href="boatOrdinaryReservationsFuture">
            Boat
          </NavDropdown.Item>
          <NavDropdown.Item href="fishingClassOrdinaryReservationsFuture">
            FishingClass
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="cottageQuickReservationsFuture">
            QuickCottage
          </NavDropdown.Item>
          <NavDropdown.Item href="boatQuickReservationsFuture">
            QuickBoat
          </NavDropdown.Item>
          <NavDropdown.Item href="fishingClassQuickReservationsFuture">
            QuickFishingClass
          </NavDropdown.Item>
        </NavDropdown>

        <NavDropdown title="All reservations">
          <NavDropdown.Item href="OrdinaryCottageReservationAll">
            Cottage
          </NavDropdown.Item>
          <NavDropdown.Item href="OrdinaryBoatReservationAll">
            Boat
          </NavDropdown.Item>
          <NavDropdown.Item href="OrdinaryFishingClassReservationAll">
            FishingClass
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="cottageReservationClientAll">
            QuickCottage
          </NavDropdown.Item>
          <NavDropdown.Item href="boatReservationClientAll">
            QuickBoat
          </NavDropdown.Item>
          <NavDropdown.Item href="fishingClassReservationClientAll">
            QuickFishingClass
          </NavDropdown.Item>
        </NavDropdown>

        <Nav.Link href="login">Logout</Nav.Link>
      </Nav>
    </Navbar>
  );
}
