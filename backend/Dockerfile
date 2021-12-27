FROM mcr.microsoft.com/dotnet/sdk:6.0
WORKDIR /src
COPY ["backend.csproj", ""]
RUN dotnet restore "./backend.csproj"
COPY . .
RUN dotnet dev-certs https --trust
ENTRYPOINT dotnet watch run --urls=http://+:5001 --project backend.csproj