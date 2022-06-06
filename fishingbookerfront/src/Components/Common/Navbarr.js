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
        <Nav.Link href="instructorHomePage">Home Page</Nav.Link>
        <Nav.Link href="fishingClassByInstructor">Fishing Classes</Nav.Link>

        <NavDropdown title="Reservations">
          <NavDropdown.Item href="currentReservations">
            Current Reservations
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="fishingClassReservationHistory">
            History Reservations
          </NavDropdown.Item>
        </NavDropdown>

        <Nav.Link href="calendar">Schedule</Nav.Link>
        <Nav.Link href="clientsByInstructor">My Clients</Nav.Link>
      </Nav>
    </Navbar>
  );
}
