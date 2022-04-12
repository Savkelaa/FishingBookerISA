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
        <NavDropdown title="Services">
          <NavDropdown.Item href="#Services/Fishing Classes">
            Fishing Classes
          </NavDropdown.Item>
          <NavDropdown.Item href="#Services/Cottages">
            Cottages
          </NavDropdown.Item>
          <NavDropdown.Item href="#Services/Boats">Boats</NavDropdown.Item>
          <NavDropdown.Divider />
          <NavDropdown.Item href="#products/promo">Promo</NavDropdown.Item>
        </NavDropdown>

        <Nav.Link href="#blog">Nikola</Nav.Link>
        <Nav.Link href="#blog">Blog</Nav.Link>
        <Nav.Link href="#blog">Blog</Nav.Link>
        <Nav.Link href="#blog">Blog</Nav.Link>
        <Nav.Link href="#about-us">About Us</Nav.Link>
        <Nav.Link href="#contact-us">Contact Us</Nav.Link>
      </Nav>
    </Navbar>
  );
}
