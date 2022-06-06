import React from "react";
import { Nav, Navbar, NavbarBrand, NavDropdown, Table } from "react-bootstrap";
import logo from "../../Assets/img/logo.jpg";

export default function NavbarLogin() {
  return (
    <Navbar bg="dark" variant="dark" sticky="top">
      <NavbarBrand className="brand" expand="lg">
        <img src={logo} height="30px" width="50px" margin="auto" />
        FishingBooker
      </NavbarBrand>
      <Navbar.Toggle className="coloring" />
      <Nav>
      

        <Nav.Link href="#blog"></Nav.Link>

        <Nav.Link href="/login">Login</Nav.Link>
        <Nav.Link href="userRegistration">Registration</Nav.Link>
      </Nav>
    </Navbar>
  );
}
