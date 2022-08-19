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

        <NavDropdown title="CottageReservations">
          <NavDropdown.Item href="cottageReservationClientAll">
            All
          </NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="cottageReservationHistoryByClient">
            In history
          </NavDropdown.Item>
          <NavDropdown.Item href="allBoats">
            In future
          </NavDropdown.Item>
        </NavDropdown>

        <Nav.Link href="login">Logout</Nav.Link>
      </Nav>
    </Navbar>
  );
}
