import format from "date-fns/format";
import getDay from "date-fns/getDay";
import parse from "date-fns/parse";
import startOfWeek from "date-fns/startOfWeek";
import React, { useEffect, useState } from "react";
import { Calendar, dateFnsLocalizer } from "react-big-calendar";
import "react-big-calendar/lib/css/react-big-calendar.css";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import Footerr from "../Components/Common/Footerr";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";

const locales = {
  "en-US": require("date-fns/locale/en-US"),
};
const localizer = dateFnsLocalizer({
  format,
  parse,
  startOfWeek,
  getDay,
  locales,
});

// const events = [
//   {
//     title: "Big Meeting",
//     allDay: false,
//     start: new Date(2022, 5, 2),
//     end: new Date(2022, 5, 10),
//   },
//   {
//     title: "Vacation",
//     start: new Date(2022, 6, 7),
//     end: new Date(2022, 6, 10),
//   },
//   {
//     title: "Conference",
//     start: new Date(2022, 5, 7),
//     end: new Date(2022, 5, 12),
//   },
// ];

export default function CalendarContainer() {
  const [newEvent, setNewEvent] = useState({ title: "", start: "", end: "" });
  const [
    fishingClassReservationsByInstructor,
    setfishingClassReservationsByInstructor,
  ] = useState([]);

  const [allEvents, setAllEvents] = useState([]);

  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  function handleAddEvent() {
    setAllEvents([...allEvents, newEvent]);
  }

  console.log("allEvents", allEvents);

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllFishingClassReservationsByInstructor(logedInstructor.id)
      .then(({ data }) => {
        console.log("fishingClassReservations", data);
        setAllEvents(
          data.map(
            ({
              fishingClass,
              startDate,
              finishDate,
              client: { name, surname },
            }) => ({
              title: `Reservation: ${fishingClass.name} - ${name} ${surname} : ${startDate} - ${finishDate} , ${fishingClass.price} euro, ${fishingClass.maxPeople} people`,
              start: new Date(startDate),
              end: new Date(finishDate),
            })
          )
        );
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getAllDateSpansInstructor(logedInstructor.id)
      .then(({ data }) => {
        console.log("free", data);
        setAllEvents((allEvents) => [
          ...allEvents,
          ...data.map(({ startDate, endDate }) => ({
            title: `FREE`,
            start: new Date(startDate),
            end: new Date(endDate),
          })),
        ]);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getAllFishingClassQuickReservationsByInstructor(logedInstructor.id)
      .then(({ data }) => {
        console.log("free", data);
        setAllEvents((allEvents) => [
          ...allEvents,
          ...data.map(
            ({
              fishingClass,
              startDateAction,
              finishDateAction,
              client: { name, surname },
            }) => ({
              title: `Quick Reservation: ${fishingClass.name} - ${name} ${surname} : ${startDateAction} - ${finishDateAction} , ${fishingClass.price} euro, ${fishingClass.maxPeople} people`,
              start: new Date(finishDateAction),
              end: new Date(finishDateAction),
            })
          ),
        ]);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <h1>Calendar</h1>
      <h2>Add New Event</h2>
      <div>
        <input
          type="text"
          placeholder="Add Title"
          className="form-control"
          style={{ width: "20%", marginRight: "10px" }}
          value={newEvent.title}
          onChange={(e) => setNewEvent({ ...newEvent, title: e.target.value })}
        />
        <DatePicker
          className="form-control"
          placeholderText="Start Date"
          style={{ width: "20%", marginRight: "10px" }}
          selected={newEvent.start}
          onChange={(start) => setNewEvent({ ...newEvent, start })}
        />
        <DatePicker
          className="form-control"
          placeholderText="End Date"
          style={{ width: "20%", marginRight: "10px" }}
          selected={newEvent.end}
          onChange={(end) => setNewEvent({ ...newEvent, end })}
        />
        <button
          className="btn btn-info"
          stlye={{ marginTop: "10px" }}
          onClick={handleAddEvent}
        >
          Add Event
        </button>
      </div>
      <Calendar
        localizer={localizer}
        events={allEvents}
        startAccessor="start"
        endAccessor="end"
        style={{
          height: 700,
          marginLeft: "50px",
          marginRight: "50px",
          marginTop: "200px",
          marginBottom: "150px",
        }}
      />
      <Footerr></Footerr>
    </div>
  );
}
