const axios = require("axios");

const cottageServices = {
  getAllCottages: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}cottages`);
  },
  addCottage: (cottage) => {
    return axios.post(`${process.env.REACT_APP_API_URL}cottages`, cottage);
  },
  deleteCottage: (cottageID) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}cottages/${cottageID}`
    );
  },
  updateCottage: (cottage) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}cottages/${cottage.id}`,
      cottage
    );
  },
  getCottagesByOwner: (cottageOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottagesByOwner?cottageOwnerId=${cottageOwnerId}`
    );
  },
  getCottagesById: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottages/${cottageId}`
    );
  },
  getBehavioralRuleByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageBehavioralRulesByCottage?cottageId=${cottageId}`
    )
  },
  getAdditionalServicesByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}additionalServicesByCottage?cottageId=${cottageId}`
    )
  },

  getImagesByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageImage?cottageId=${cottageId}`
    )
  },

  searchCottageByName: (cottageOwnerId, cottageName) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottagesByOwnerAndName?cottageOwnerId=${cottageOwnerId}&cottageName=${cottageName}`
    );
  }
};

export default cottageServices;
