##Tạo migration##
dotnet ef migrations add InitialCreate

##Update database##
dotnet ef database update

##Reset migration##
dotnet ef database drop -f -v
dotnet ef migrations add InitialCreate
dotnet ef database update